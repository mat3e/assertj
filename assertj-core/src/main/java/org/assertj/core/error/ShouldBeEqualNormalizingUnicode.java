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
package org.assertj.core.error;

/**
 * Creates an error message indicating that an assertion that verifies that two {@code CharSequence}s are equal,
 * on their canonical form relying on {@link java.text.Normalizer}, failed.
 *
 * @author Julieta Navarro
 */
public class ShouldBeEqualNormalizingUnicode extends BasicErrorMessageFactory {

  /**
   * Creates a new <code>{@link org.assertj.core.error.ShouldBeEqualNormalizingUnicode}</code>.
   * @param actual the actual value in the failed assertion.
   * @param expected the expected value in the failed assertion.
   * @param normalizedActual the normalized actual value in the failed assertion.
   * @param normalizedExpected the normalized expected value in the failed assertion.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeEqualNormalizingUnicode(CharSequence actual, CharSequence expected,
                                                                    CharSequence normalizedActual,
                                                                    CharSequence normalizedExpected) {
    return new ShouldBeEqualNormalizingUnicode(actual, expected, normalizedActual, normalizedExpected);
  }

  private ShouldBeEqualNormalizingUnicode(CharSequence actual, CharSequence expected, CharSequence normalizedActual,
                                          CharSequence normalizedExpected) {
    super("%nExpecting actual:%n  %s%nto be equal to:%n  %s%n" +
          "after they have been normalized according to the Normalizer.Form.NFC form.%n" +
          "The normalized strings should be equal.%n" +
          "Normalized actual  : %s%n" +
          "Normalized expected: %s",
          actual, expected, normalizedActual, normalizedExpected);
  }
}
