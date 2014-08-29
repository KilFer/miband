.class public interface abstract Lcom/tencent/mm/sdk/event/EventPoolFactory$IEventPool;
.super Ljava/lang/Object;


# virtual methods
.method public abstract add(Ljava/lang/String;Lcom/tencent/mm/sdk/event/IListener;)Z
.end method

.method public abstract asyncPublish(Lcom/tencent/mm/sdk/event/IEvent;)V
.end method

.method public abstract asyncPublish(Lcom/tencent/mm/sdk/event/IEvent;Landroid/os/Looper;)V
.end method

.method public abstract publish(Lcom/tencent/mm/sdk/event/IEvent;)V
.end method

.method public abstract release(I)V
.end method

.method public abstract remove(Ljava/lang/String;Lcom/tencent/mm/sdk/event/IListener;)Z
.end method
