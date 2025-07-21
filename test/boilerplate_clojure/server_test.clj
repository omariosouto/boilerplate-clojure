(ns boilerplate-clojure.server-test
  (:require [clojure.test :refer [is]]
            [state-flow.api :refer [defflow flow]]
            [io.pedestal.test :refer [response-for]]
            [io.pedestal.http :as http]
            [boilerplate-clojure.server :as server]))

(defflow home-page-responds
  (flow "GET / returns Hello from Pedestal!"
    (let [service-map (assoc server/service ::http/join? false)
          service    (io.pedestal.http/create-servlet service-map)
          response   (response-for service :get "/")]
      (is (= 200 (:status response)))
      (is (= "Hello from Pedestal!" (:body response)))))) 
      