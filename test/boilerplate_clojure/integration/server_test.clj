(ns boilerplate-clojure.integration.server-test
  (:require [clojure.test :refer [is]]
            [state-flow.api :refer [defflow flow]]
            [state-flow.assertions.matcher-combinators :refer [match?]]
            [io.pedestal.test :refer [response-for]]
            [io.pedestal.http :as http]
            [boilerplate-clojure.server :as server]))

;; (defflow home-page-responds
;;   (flow "GET / returns Hello from Pedestal!"
;;     (let [service-map (assoc (server/service) ::http/join? false)
;;           servlet     (http/create-servlet service-map)
;;           response    (response-for servlet :get "/")]
;;       (is (= 200 (:status response)))
;;       (is (= "Hello from Pedestal!" (:body response)))))
;; )
;; Temporarily commented out to debug state-flow test setup. Only simple-math-works is active.

(defflow simple-math-works
  (flow "Simple math test"
    (match? 4 (+ 2 2)))) 