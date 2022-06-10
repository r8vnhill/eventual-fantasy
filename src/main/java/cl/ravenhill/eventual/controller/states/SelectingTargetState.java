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

public class SelectingTargetState extends GameState {
  public SelectingTargetState(GameController context) {
    super(context);
  }

  @Override
  public void toRunningState() {
    context.setState(new RunningState(context));
  }

  @Override
  public void doAction() throws UnsupportedStateOperationException {
    context.doAttack();
  }
}
