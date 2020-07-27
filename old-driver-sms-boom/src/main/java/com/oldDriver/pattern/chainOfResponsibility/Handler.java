package com.oldDriver.pattern.chainOfResponsibility;

/**
 * 请填写类的描述
 *
 * @author mawenjie12
 * @date 2020-07-27 18:10
 */
public abstract class Handler {

    protected Handler successor;

    //设置继任者
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void HandleRequest(int request);
}


