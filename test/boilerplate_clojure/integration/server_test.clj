(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer :all]
            [io.pedestal.test :refer [response-for]]
            [boilerplate-clojure.server :as server]
            [io.pedestal.http :as http]))

(def service-fn
  (-> (server/service {:env :test})
      (::http/service-fn)))

(deftest home-page-responds
  (let [response (response-for service-fn :get "/")]
    (is (= 200 (:status response)))
    (is (= "Hello from Pedestal!" (:body response)))))

(deftest simple-math-works
  (is (= 4 (+ 2 2))))
