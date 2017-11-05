(ns lol-api.server
  (:require [compojure.core :refer [defroutes GET POST ]]
            [compojure.handler :as handler]
            [org.httpkit.server :as httpkit]
            [ring.middleware.json :as json-middleware]

            ; routes
            [lol-api.routes.user :as user]))

(defonce server (atom nil))

(defroutes app-routes
  (POST "/signup" [] user/signup)
  (POST "/login" [] user/login)
  (POST "/logout" [] user/logout))

(def app
  (-> (handler/api app-routes)
      (json-middleware/wrap-json-body {:keywords? true})
      json-middleware/wrap-json-params
      json-middleware/wrap-json-response))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout (* 10 1000)) ; allow 10 seconds for requests to finish
    (reset! server nil)))

(defn -main [& args]
  (reset! server (httpkit/run-server #'app {:port 8080})))

; --- repl code ---

(comment

  (-main)
  (stop-server)

)
