(ns trial.views
  (:require
    [re-frame.core :as re-frame]
    [trial.subs :as subs]
    [reagent.core :as r]
    [soda-ash.core :as sa]))

(defn my-country
  [final] [:input
           {:type      "text"
            :value     (get @final :country)
            :on-change #(swap! final assoc :country (-> % .-target .-value))}])

(defn my-identity
  [final] [:input
           {:type      "text"
            :value     (get @final :identity)
            :on-change #(swap! final assoc :identity (-> % .-target .-value))}])

(defn my-form
  []
  (let [final (r/atom {:identity "  NAME"
                       :country  " Country"})]
    (fn []
      [:div
       [:h3 "Enter your name :- " [my-identity final]]
       [:h3  "Enter your country :- " [my-country final]]
       [:input {:type     "button"
                :value    "submit"
              [sa/Button { :basic    true
                          :on-click #(re-frame/dispatch [:submit @final])}] }]])))


(defn show-result
[last-submitted country]

 [:div [:h3 "YOUR NAME :- " last-submitted  ]
  [:h3  "YOUR COUNTRY:- " country]] )

(defn show-all-values
[ all-values]
 [:ol (for [item all-values]
            ^{:key (str item)}
            [:li "YOUR NAME :- " (str item) ]  )
      ]
)


(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        all-values (re-frame/subscribe [::subs/all-values])
        last-submitted (re-frame/subscribe [::subs/last-submitted])
        ]


    [:div

     [my-form]
      [show-result (get @last-submitted :identity) (get @last-submitted :country)   ]

      [show-all-values @all-values  ]


     ]

    ))
