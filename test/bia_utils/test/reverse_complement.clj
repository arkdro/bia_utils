(ns bia_utils.test.reverse_complement
  (:use [bia_utils.reverse_complement])
  (:use [clojure.test]))

(deftest rev-complement-test
  (is (= [\A \C \A \T] (rev-complement [\A \T \G \T])))
  (is (= [\A \T \G \T] (rev-complement [\A \C \A \T])))
  )

(deftest rev-complement-str-test
  (is (= "ACAT" (rev-complement-str "ATGT")))
  (is (= "ATGT" (rev-complement-str "ACAT")))
  )

