(ns bia_utils.reverse_complement
  {:doc "complementing a strand of dna"}
  )

(defn transcribe [data]
  (let [smap {\A \T
              \T \A
              \C \G
              \G \C}]
    (replace smap data)))

(defn rev-complement [data]
  (let [transcribed (transcribe data)]
    (reverse transcribed)))

(defn rev-complement-str [data]
  (apply str (rev-complement data)))

