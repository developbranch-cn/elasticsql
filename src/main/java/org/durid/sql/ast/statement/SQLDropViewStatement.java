/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.durid.sql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import org.durid.sql.ast.SQLName;
import org.durid.sql.ast.SQLStatementImpl;
import org.durid.sql.visitor.SQLASTVisitor;

public class SQLDropViewStatement extends SQLStatementImpl implements SQLDDLStatement {

    private static final long          serialVersionUID = 1L;

    protected List<SQLExprTableSource> tableSources     = new ArrayList<SQLExprTableSource>();

    public SQLDropViewStatement(){

    }

    public SQLDropViewStatement(SQLName name){
        this(new SQLExprTableSource(name));
    }

    public SQLDropViewStatement(SQLExprTableSource tableSource){
        this.tableSources.add(tableSource);
    }

    public List<SQLExprTableSource> getTableSources() {
        return tableSources;
    }

    public void setTableSources(List<SQLExprTableSource> tableSources) {
        this.tableSources = tableSources;
    }

    public void setName(SQLName name) {
        this.addTableSource(new SQLExprTableSource(name));
    }
    
    public void addTableSource(SQLName name) {
        this.addTableSource(new SQLExprTableSource(name));
    }
    
    public void addTableSource(SQLExprTableSource tableSource) {
        tableSources.add(tableSource);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, tableSources);
        }
        visitor.endVisit(this);
    }
}
