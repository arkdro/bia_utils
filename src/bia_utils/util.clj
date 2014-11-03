(ns bia_utils.util
  ;; (:use clojure.tools.trace)
  )

;;(trace-ns 'bia_utils.util)

(defn is-data-available [i len k]
  (let [end (+ i k)]
    (<= end len)))

(defn get-one-k-mer [i text k]
  (let [end (+ i k)
        k-mer (subs text i end)]
    k-mer))

(defn add-one-k-mer [i text k acc]
  (let [k-mer (get-one-k-mer i text k)
        new-acc (update-in acc [k-mer] (fnil inc 0))]
    new-acc))

(defn add-provided-k-mer [k-mer acc]
  (update-in acc [k-mer] (fnil inc 0)))

(defn find-max-value-aux [acc [h & t]]
  (cond
   (nil? h) acc
   (> (second h) acc) (recur (second h) t)
   :default (recur acc t)))

(defn find-max-value
  "Given a sequence of items of size 2 (i.e. key-value),
   find the max of the values"
  [[h & t :as data]]
  (find-max-value-aux (second h) data))

(defn find-max-items
  "Given a sequence of items of size 2 (i.e. key-value),
   find the items which contain the max values"
  [data]
  (let [max-val (find-max-value data)
        items (filter #(= (second %) max-val) data)]
    items))

