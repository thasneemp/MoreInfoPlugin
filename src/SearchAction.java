import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

public abstract class SearchAction extends AnAction {


    protected abstract String getSite();

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        String site = getSite();
        CaretModel caretModel = e.getData(LangDataKeys.EDITOR).getCaretModel();
        Caret currentCaret =
                caretModel.getCurrentCaret();
        String selectedText = currentCaret.getSelectedText().trim();
        try {
            selectedText = selectedText.replaceAll(" ", "+");
        } catch (NullPointerException ex) {
            System.out.print("Text is empty" + ex.getMessage());
        }

        if (StringUtils.isNotBlank(selectedText)) {
            BrowserUtil.browse(site + selectedText);
        } else {
            BrowserUtil.browse(site);
        }
    }
}
