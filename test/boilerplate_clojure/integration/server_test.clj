(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [deftest is]]
            [io.pedestal.test :refer [response-for]]
            [io.pedestal.http :as http]
            [boilerplate-clojure.server :as server]))

(deftest home-page-responds
  (let [servlet (http/create-servlet (server/service-map))
        response (response-for servlet :get "/")]
    (is (= 200 (:status response)))
    (is (= "Hello from Pedestal!" (:body response)))))

(deftest simple-math-works
  (is (= 4 (+ 2 2)))) 