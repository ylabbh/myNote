package 代理模式.三_另一种演示_虚拟代理.例二;

/**
 * (场景就是: 大家都是来找老板做事的, 并不是来找助手做事的, 助手只负责在老板不在的时候帮老板收集大家的需求, 最后收集完了, 他就把老板邀请过来, 老板来处理所有的事情).
 *
 * 老板和助手都需要实现这个接口.
 *
 * 助手实现这个接口, 当调用助手的approve方法时, 助手就会去邀请老板过来, 让老板处理清单.
 *
 * 老板实现这个接口, 是因为这些清单就需要老板来处理(approve)
 */
public interface Approvable {
    void approve() ;
}