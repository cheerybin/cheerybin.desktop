(defproject cheerybin-desktop "0.0.1"
  :description "front end framework for Chat Apps"
  :url "https://github.com/cheerybin/cheerybin.desktop"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.339"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.6"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.16"]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/main.js"
                                    "resources/public/js"]

  :profiles {:dev {:cljsbuild
                   {:builds
                    [{:id "main"
                      :source-paths ["src/app"]
                      ; :figwheel     {:on-jsload ""}
                      :compiler     {:output-to      "resources/main.js"
                                     :optimizations  :none
                                     :main           app.main.core
                                     :install-deps   true
                                     :target         :nodejs
                                     :parallel-build true
                                     :source-map     true}}

                     {:id "ui"
                      :source-paths ["src/app"]
                      :compiler     {:output-to      "resources/public/js/app.js"
                                     :optimizations  :none
                                     :main           app.ui.core
                                     :install-deps   true
                                     :target         :nodejs
                                     :hashbang       false
                                     :parallel-build true
                                     :source-map     true}}]}}

             :prod {:cljsbuild
                    {:builds
                      [{:id "main"
                        :source-paths ["src/app"]
                        :compiler     {:output-to      "resources/main.js"
                                       :optimizations  :advanced
                                       :main           app.main.core
                                       :install-deps   true
                                       :target         :nodejs
                                       :parallel-build true
                                       :process-shim   true
                                       :pretty-print   false
                                       :elide-asserts  true}}

                       {:id "ui"
                        :source-paths ["src/app"]
                        :compiler     {:output-to      "resources/public/js/app.js"
                                       :optimizations  :advanced
                                       :main           app.ui.core
                                       :install-deps   true
                                       :target         :nodejs
                                       :hashbang       false
                                       :parallel-build true
                                       :process-shim   true
                                       :pretty-print   false
                                       :elide-asserts  true}}]}}})
