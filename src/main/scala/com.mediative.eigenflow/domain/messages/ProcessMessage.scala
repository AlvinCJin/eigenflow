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

package com.mediative.eigenflow.domain.messages

/**
 * Message for process state changes.
 *
 * @param timestamp Time when the message was created.
 * @param jobId Job identifier
 * @param processId Process identification.
 * @param processingDate Processing date of the process.
 * @param state Process state.
 * @param duration How long did it take to switch to the given state.
 *                 Initial state's duration should be 0.
 * @param message Additional information relevant to the process state.
 *                For example: the complete state message will be the next processing date,
 *                or the failed state message will contain exception details.
 */
case class ProcessMessage(
  timestamp: Long,
  jobId: String,
  processId: String,
  processingDate: String,
  state: String,
  duration: Long,
  message: String)
