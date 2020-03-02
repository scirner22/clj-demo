(defproject clj-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [compojure "1.6.0"]
                 [http-kit "2.2.0"]
                 [ring/ring-json "0.4.0"]
                 [liberator "0.15.1"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/tools.logging "0.4.0"]
                 [honeysql "0.9.1"]
                 [org.clojure/java.jdbc "0.7.3"]
                 [org.postgresql/postgresql "42.1.4"]
                 [com.novemberain/validateur "2.5.0"]]
  :main demo.server)
