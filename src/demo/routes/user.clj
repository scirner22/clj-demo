(ns demo.routes.user
  (:require [ring.util.response :refer [response]]))

(defn create [req]
  (response {:page "signup"}))

(defn get [req]
  (response {:page "login"}))
