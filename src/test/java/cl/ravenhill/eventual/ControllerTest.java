package cl.ravenhill.eventual;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.lifecycle.BeforeProperty;
import org.jetbrains.annotations.NotNull;
import static org.junit.jupiter.api.Assertions.*;

/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */
class ControllerTest {
  private Controller controller;

  @BeforeProperty
  void beforeProperty() {
    controller = new Controller();
  }

  @Property
  @Label("Controller can create playable characters correctly.")
  void createPlayerTest(@ForAll @NotNull String name) {
    var expected = new PlayableCharacter(name);
    var character = controller.createPlayableCharacter(name);
    assertEquals(expected, character);
  }
}