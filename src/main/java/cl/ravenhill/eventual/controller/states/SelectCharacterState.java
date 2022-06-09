/*
 * "eventual-fantasy" (c) by R8V.
 * "eventual-fantasy" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

package cl.ravenhill.eventual.controller.states;

import cl.ravenhill.eventual.controller.Controller;

public class SelectCharacterState extends State {
  public SelectCharacterState(Controller context) {
    super(context);
    context.promptCharacterSelection();
  }

  @Override
  public void toIdleState() {
    context.setState(new IdleState(context));
  }
}
