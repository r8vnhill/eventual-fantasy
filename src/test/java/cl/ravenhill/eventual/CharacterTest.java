/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import org.jetbrains.annotations.NotNull;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

  @Property
  @Label("Characters with different parameters should not be equal.")
  void notEqualsTest(@ForAll @NotNull String name1, @ForAll String name2) {
    // We enforce that the names are different to avoid the case where the names are the same, also,
    // we check that the names are not empty because the hash code of different empty strings is
    // always 0 (yes, there's more than one empty string in the universe).
    if (!name1.equals(name2)) {
      var character1 = new GameCharacter(name1);
      var character2 = new GameCharacter(name2);
      assertNotEquals(character1, character2);
    }
  }

  @Property
  @Label("Characters with the same parameters should be equal.")
  void equalsTest(@ForAll @NotNull String name) {
    var playableCharacter = new GameCharacter(name);
    var expected = new GameCharacter(name);
    assertAll(
        () -> assertNotSame(expected, playableCharacter),
        () -> assertEquals(expected, playableCharacter),
        () -> assertEquals(expected.hashCode(), playableCharacter.hashCode(),
                           "Hash codes should be equal.")
    );
  }
}