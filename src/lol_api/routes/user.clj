(ns lol-api.routes.user
  (:require [ring.util.response :refer [response]]))

(defn signup [req]
  (response {:page "signup"}))

(defn login [req]
  (response {:page "login"}))

(defn logout [req]
  (response {:page "logout"}))
