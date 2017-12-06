(ns demo.routes.user
  (:require [ring.util.response :refer :all]
            [validateur.validation :as v]
            [demo.db.user :as user-db]))

(defn bad-request [body]
  {:status 400
   :body body})

(def validation
  (v/validation-set
   (v/presence-of #{:name :email :password})
   (v/all-keys-in #{:name :email :password})
   (v/validate-by :name string? :message "must be a string")
   (v/validate-by :email string? :message "must be a string")
   (v/validate-by :password string? :message "must be a string")))

(defn create [{:keys [params] :as req}]
  (def params params)
  (if (v/invalid? validation params)
    (bad-request (validation params))
    (let [{:keys [id] :as new-user} (user-db/add params)]
      (created (format "/users/%s" id) new-user))))

(defn get [req]
  (response {:page "login"}))
