(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [deftest is]]
            [state-flow.api :refer [defflow flow]]
            [io.pedestal.test :refer [response-for]] 
            [boilerplate-clojure.server :as server]
            [io.pedestal.http :as http]))

(defn make-request [{:keys [path method body]}]
  (let [service-map (server/service {:env :test})
        service-fn (::http/service-fn service-map)]
    (response-for service-fn method path body)))

(deftest home-page-responds
  (let [response (make-request {:path "/"
                                :method :get
                                :body "Hello from Pedestal!"})]
    (is (= 200 (:status response)))
    (is (= "Hello from Pedestal!" (:body response)))))

(deftest simple-math-works
  (is (= 4 (+ 2 2))))
