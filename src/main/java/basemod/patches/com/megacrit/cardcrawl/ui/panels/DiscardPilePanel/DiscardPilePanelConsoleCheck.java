package basemod.patches.com.megacrit.cardcrawl.ui.panels.DiscardPilePanel;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

@SpirePatch(cls="com.megacrit.cardcrawl.ui.panels.DiscardPilePanel", method="updatePositions")
public class DiscardPilePanelConsoleCheck {
    public static ExprEditor Instrument() {
        return new ExprEditor() {
            public void edit(MethodCall m) throws CannotCompileException {
                if (m.getClassName().equals("com.badlogic.gdx.Input") && m.getMethodName().equals("isKeyJustPressed")) {
                    m.replace("{ $_ = !basemod.DevConsole.visible && $proceed($$); }");
                }
            }
        };
    }
}