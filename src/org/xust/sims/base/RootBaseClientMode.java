package org.xust.sims.base;

/**
 * ʹ��Root��������Ա�˻���¼���ݿ�
 */
public class RootBaseClientMode extends BaseClientMode {
    private static final RootBaseClientMode modesession = new RootBaseClientMode();
    private RootBaseClientMode(){
        setAccount("root");
        setPassword("XUST2020");
    }

    public RootBaseClientMode getModeSession(){
        return modesession;
    }
}
