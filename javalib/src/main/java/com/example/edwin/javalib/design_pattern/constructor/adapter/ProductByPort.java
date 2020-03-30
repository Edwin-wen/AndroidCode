package com.example.edwin.javalib.design_pattern.constructor.adapter;

/**
 * 这个产品是要通过这个统一接口去做一些事情的，但是又自身又没办法适配这个接口
 * 所以要new一个适配器adapter，让我们通过这个adapter类可使用到这个接口
 */
public class ProductByPort implements IPort {

    private Object realFunc = null;
    private ProductAdapter adapter;         // 这个就是为了产品类能通过统一接口提供服务，而产生的adapter类

    public ProductByPort(Object realFunc) {
        this.realFunc = realFunc;
        initAdapter();
    }

    private void initAdapter() {
        adapter = new ProductAdapter(realFunc);
    }

    @Override
    public void doThingByPort() {
        adapter.tranform();
    }
}
