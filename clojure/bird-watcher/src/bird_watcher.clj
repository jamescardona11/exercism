(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4]
  )

(defn today [birds] (last birds)
  
  )

(defn inc-bird [birds] (conj (pop birds) (+ (today birds) 1))
  )

(defn day-without-birds? [birds]
  (cond (some (partial = 0) birds) true :default false )
  )

(defn n-days-count [birds n] (reduce + (take n birds))
  )

(defn busy-days [birds] (count (filter (fn [x] (> x 4)) birds))
  )

(defn count0 [birds] (count (filter #(= % 0) birds)))
(defn count1 [birds] (count (filter #(= % 1) birds)))



(defn counting? [birds]
  (let [count0 (count0 birds) count1 (count1 birds)]
    (-> [count0 count1]
      (and (or (= count0 3) (= count0 4)) (or (= count1 3) (= count1 4)))
    )
  )
)

;; (defn odd-week? [birds] (and (or (= (count0 birds) 3) (= (count0 birds) 4)) (or (= (count1 birds) 3) (= (count1 birds) 4)))
;;   )

;; (defn odd-week? [birds]  ((let [count0 (count0 birds) count1 (count1 birds)] (and (or ) (or (= count1 3) (= count1 4))))
;;   )
(defn odd-week? [birds] (counting? birds))

 

