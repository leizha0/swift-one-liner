(ns swift-one-liner.core
  (:import [com.facebook.swift.codec ThriftCodecManager ThriftCodec]
           [com.facebook.swift.service ThriftServiceProcessor ThriftClientManager ThriftServerConfig ThriftServer]
           [myinterface MyService]))

(defn make-server-config [config]
  (let [server-config (ThriftServerConfig.)]
    (when-let [a (:worker-threads config)] (.setWorkerThreads server-config a))
    (when-let [a (:port config)] (.setPort server-config a))
    server-config))

(defn start-simple-thrift-server [handler config]
  (let [codec-manager (ThriftCodecManager. (into-array ThriftCodec []))
        client-manager (ThriftClientManager.)
        processor (ThriftServiceProcessor. codec-manager [] (into-array Object [handler]))
        server (ThriftServer. processor (make-server-config config))]
    (.start server)
    server))

(def my-handler (reify MyService
                  (getName [_] "helloSwift")))

(start-simple-thrift-server my-handler {:worker-threads 32 :port 12345})
