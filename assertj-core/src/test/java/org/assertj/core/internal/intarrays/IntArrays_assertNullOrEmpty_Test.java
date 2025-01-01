/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2025 the original author or authors.
 */
package org.assertj.core.internal.intarrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.error.ShouldBeNullOrEmpty.shouldBeNullOrEmpty;
import static org.assertj.core.testkit.IntArrays.emptyArray;
import static org.assertj.core.testkit.TestData.someInfo;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.IntArrays;
import org.assertj.core.internal.IntArraysBaseTest;
import org.junit.jupiter.api.Test;

/**
 * Tests for <code>{@link IntArrays#assertNullOrEmpty(AssertionInfo, int[])}</code>.
 * 
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
class IntArrays_assertNullOrEmpty_Test extends IntArraysBaseTest {

  @Test
  void should_fail_if_array_is_not_null_and_is_not_empty() {
    AssertionInfo info = someInfo();
    int[] actual = { 6, 8 };

    Throwable error = catchThrowable(() -> arrays.assertNullOrEmpty(info, actual));

    assertThat(error).isInstanceOf(AssertionError.class);
    verify(failures).failure(info, shouldBeNullOrEmpty(actual));
  }

  @Test
  void should_pass_if_array_is_null() {
    arrays.assertNullOrEmpty(someInfo(), null);
  }

  @Test
  void should_pass_if_array_is_empty() {
    arrays.assertNullOrEmpty(someInfo(), emptyArray());
  }
}
