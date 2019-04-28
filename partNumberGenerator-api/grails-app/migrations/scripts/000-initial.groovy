databaseChangeLog = {

    changeSet(author: "chaubner (generated)", id: "1530561608589-1") {

        createTable(tableName: "customer") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "customerPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "internal_id", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "chaubner (generated)", id: "1530561608589-2") {
        createTable(tableName: "part_number") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "part_numberPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "internal_id", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "customer_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "revision", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "chaubner (generated)", id: "1530561608589-3") {
        addForeignKeyConstraint(baseColumnNames: "customer_id", baseTableName: "part_number", constraintName: "FKqsnoje4cabwymebdne8eqv071", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "customer")
    }
}
