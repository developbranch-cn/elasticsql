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

import org.durid.sql.ast.SQLObjectImpl;
import org.durid.sql.visitor.SQLASTVisitor;

public class SQLAlterTableAddPrimaryKey extends SQLObjectImpl implements SQLAlterTableItem {

    private static final long serialVersionUID = 1L;
    private SQLPrimaryKey     primaryKey;

    public SQLPrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(SQLPrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, primaryKey);
        }
        visitor.endVisit(this);
    }

}
