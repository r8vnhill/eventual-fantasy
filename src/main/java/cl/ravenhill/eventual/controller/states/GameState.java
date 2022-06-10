/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller.states;

import cl.ravenhill.eventual.controller.GameController;
import cl.ravenhill.eventual.exceptions.UnsupportedStateOperationException;
import org.jetbrains.annotations.NotNull;

public class GameState {
  protected final GameController context;

  protected GameState(@NotNull GameController context) {
    this.context = context;
    context.setState(this);
  }

  public void toRunningState() throws UnsupportedStateOperationException {
    transitionError(RunningState.class.getSimpleName());
  }

  public void toSelectingTargetState() throws UnsupportedStateOperationException {
    transitionError(SelectingTargetState.class.getSimpleName());
  }

  private void transitionError(String targetState) throws UnsupportedStateOperationException {
    throw new UnsupportedStateOperationException(
        "You cannot go from " + this.getClass().getSimpleName() + " to "
        + targetState);
  }

  public void doAction() throws UnsupportedStateOperationException {
    // Do nothing
  }
}
