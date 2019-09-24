(ns trial.views
  (:require
    [re-frame.core :as re-frame]
    [trial.subs :as subs]
    [reagent.core :as r]
    [soda-ash.core :as sa]))

(defn my-country
  [final] [sa/FormInput{ :label "COUNTRY  "
                        :width "5"
                        :input  "text"
                        :value (get @final :country)
                        :on-change #(swap! final assoc :country (-> % .-target .-value))} ] )

(defn my-identity
  [final] [sa/FormInput
           { :label "NAME  "
            :input-Placeholder "NAME"
            :width "5"
            :input "text"

            :value     (get @final :identity)
            :on-change #(swap! final assoc :identity (-> % .-target .-value))} ])

(defn my-form
  []
  (let [final (r/atom {:identity "  NAME"
                       :country  " Country"})]
    (fn []
      [:div
             [sa/Form {}
              [:h3  [my-identity final]]
              [:h3  [my-country final]]

              [sa/Button {
                          :circular true
                          :on-click #(re-frame/dispatch [:submit @final])} " SUBMIT"] ]]
)))


(defn show-result
[last-submitted country]

 [:div [:h3 "YOUR NAME :- " last-submitted  ]
  [:h3  "YOUR COUNTRY:- " country]] )

(defn show-all-values
[ all-values]

  (for [item all-values]
    ^{:key (str item)}
    [:li [show-result (get item :identity) (get item :country)]]
    ) ]

)


(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        all-values (re-frame/subscribe [::subs/all-values])
        last-submitted (re-frame/subscribe [::subs/last-submitted])
        ]


    [:div

     [my-form]
      [:h3 "RECENT DATA"  [show-result (get @last-submitted :identity) (get @last-submitted :country)   ]]
      [show-all-values @all-values  ]


     ]

    ))
