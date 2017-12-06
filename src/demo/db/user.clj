(ns demo.db.user
  (:require [honeysql.core :as sql]
            [honeysql.helpers :refer :all]
            [clojure.java.jdbc :as jdbc]))

(def db-spec
  {:dbtype "postgresql"
   :dbname "postgres"
   :host "postgres.local"
   :user "postgres"
   :password "password"})

(defn add [user]
  (let [response (jdbc/insert! db-spec :users user)]
    (-> response
        first
        (dissoc :password))))

(comment

  (def table-ddl
    (jdbc/create-table-ddl :users [[:id "SERIAL PRIMARY KEY"]
                                   [:email "VARCHAR(255)"]
                                   [:password "VARCHAR(255)"]
                                   [:name "VARCHAR(255)"]]))

  (jdbc/execute! db-spec table-ddl)

)
