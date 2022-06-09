/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class PlayableCharacterTest {
  private PlayableCharacter playableCharacter;

  @BeforeEach
  void setUp() {
    playableCharacter = new PlayableCharacter();
  }

  @Test
  void constructorTest() {
    var expected = new PlayableCharacter();
    assertNotSame(expected, playableCharacter);
    assertEquals(expected, playableCharacter);
    assertEquals(expected.hashCode(), playableCharacter.hashCode(), "Hash codes should be equal.");
  }
}