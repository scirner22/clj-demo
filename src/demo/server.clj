(ns demo.server
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.handler :as handler]
            [org.httpkit.server :as httpkit]
            [ring.middleware.json :as json-middleware]
            [clojure.tools.nrepl.server :as nrepl]
            [clojure.tools.logging :as log]

            ; routes
            [demo.routes.user :as user]))

(defonce server (atom nil))

(defroutes app-routes
  (POST "/users" [] user/create)
  (GET "/users/:id" [id] user/get))

(def app
  (-> (handler/api #'app-routes)
      (json-middleware/wrap-json-body {:keywords? true})
      json-middleware/wrap-json-params
      json-middleware/wrap-json-response))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout (* 10 1000)) ; allow 10 seconds for requests to finish
    (reset! server nil)))

(defn -main [& args]
  (nrepl/start-server :bind "0.0.0.0" :port 5080)
  (log/info "nrepl server started on port 5080")

  (reset! server (httpkit/run-server #'app {:port 8080}))
  (log/info "server started on port 8080"))

; --- repl code ---

(comment

  (-main)
  (reset! server (httpkit/run-server #'app {:port 8080}))
  (stop-server)

)
