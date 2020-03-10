(ns demo.routes.demo
  (:require [clj-http.client :as client]))

(defn fetch [{:keys [params] :as req}]
  (:body (client/get "https://swapi.co/api/people/1")))
