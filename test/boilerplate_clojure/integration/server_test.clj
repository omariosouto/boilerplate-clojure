(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [boilerplate-clojure.server :as server]))

(use-fixtures :once
  (fn [tests]
    (server/start)
    (Thread/sleep 1000) ; give time to boot
    (tests)
    (server/stop)))

(deftest hello-endpoint-test
  (let [response (client/get "http://localhost:8080/hello"
                             {:as :json})]
    (is (= 200 (:status response)))
    (is (= {"hello" "world"} (:body response)))))
