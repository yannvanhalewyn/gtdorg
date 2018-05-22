(ns gtdorg.android.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [gtdorg.events]
            [gtdorg.subs]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def text-input (r/adapt-react-class (.-TextInput ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def button (r/adapt-react-class (.-Button ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def scroll-view (r/adapt-react-class (.-ScrollView ReactNative)))

(def logo-img (js/require "./images/cljs.png"))

(defn alert [title]
      (.alert (.-Alert ReactNative) title))

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [view {:style {:flex-direction "column" :margin 40 :align-items "center"}}

       [button {:on-press #(dispatch [:initialize-db]) :title "Reset!" :color "#841584"}]
       [text-input {:style {:height 40 :width "100%"}
                    :placeholder "Type something.."
                    :on-change-text #(dispatch [:set-greeting %])}]

       [scroll-view
        (doall
         (for [i (range 1 9)]
           ^{:key i}
           [text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} (str @greeting " -- " i)]))]
       [image {:source logo-img
               :style  {:width 80 :height 80 :margin-bottom 30}}]
       [touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(alert "HELLO!")}
        [text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "gtdorg" #(r/reactify-component app-root)))
