(ns reddit-analyser.core
  (:require [clj-http.client :as client] 
            [cheshire.core :refer [parse-string]])  
  (:gen-class))

(def options {:headers {"User-agent" "bond-007"}
              :query-params {:limit 100}})

(def url "https://www.reddit.com/r/Clojure.json")

(parse-string (:body (client/get url options)) true)

(defn get-posts
  []
  (let [body (:body (client/get url options))
        parsed-body (parse-string body true)
        children (:children (:data parsed-body))]
    (map :data children)))

(defn good-post?
  [post]
  (> (:score post) 15))

(defn only-good-posts
  [posts]
  (filter good-post? posts))

(defn average-score
  [posts]
  (let [post-count (count posts)
        total-score (reduce + (map :score posts))]
    (float (/ total-score post-count))))

(defn post-count-helper
  [acc x]
  (update acc x (fnil inc 0)))

(defn author-post-count
  [posts]
  (let [authors (map :author posts)]
    (reduce post-count-helper {} authors)))

