package tsingtoo.tools.qqconhmos;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;
import ohos.utils.net.Uri;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Button button=(Button) findComponentById(ResourceTable.Id_button);
        button.setClickedListener(new Component.ClickedListener(){
            @Override
            public void onClick(Component component){
                TextField textField=(TextField) findComponentById(ResourceTable.Id_exitText);
                String QQNumber = textField.getText();
                String QQUrl="mqqwpa://im/chat?chat_type=wpa&version=1&uin="+QQNumber;
                Intent intent1 = new Intent();
                Operation operationCommonComponts=new Intent.OperationBuilder()
                        .withUri(Uri.parse(QQUrl))
                        .build();
                intent1.setOperation(operationCommonComponts);
                startAbility(intent1);
            }
        });
    }
}
