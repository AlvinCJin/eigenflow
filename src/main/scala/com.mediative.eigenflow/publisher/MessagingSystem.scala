/*
 * Copyright 2016 Mediative
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mediative.eigenflow.publisher

import akka.event.LoggingAdapter
import com.typesafe.config.Config

object MessagingSystem {
  def create(config: Config) = {
    Class.forName(config.getString("eigenflow.messaging")).
      getConstructor(classOf[Config])
      .newInstance(config)
      .asInstanceOf[MessagingSystem]
  }
}

abstract class MessagingSystem(config: Config) {
  def publish(topic: String, message: String)(implicit log: LoggingAdapter): Unit
  def stop(): Unit = ()
}
