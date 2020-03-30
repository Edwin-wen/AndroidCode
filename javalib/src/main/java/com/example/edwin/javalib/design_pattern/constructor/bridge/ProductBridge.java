package com.example.edwin.javalib.design_pattern.constructor.bridge;

/**
 * 即一个产品里包含很多属性（抽象接口），属性有很多种实现
 * 那么这个时候就得要一个bridge类，让客户端能通过这个桥来访问到各种属性的各个实现
 */
public class ProductBridge {

    private IColorProerty mColor;
    private IShapeProerty mShape;

    public void initProerty(IColorProerty colorProerty, IShapeProerty shapeProerty) {
        mColor = colorProerty;
        mShape = shapeProerty;
    }

    public IColorProerty getColor() {
        return mColor;
    }

    public IShapeProerty getShape() {
        return mShape;
    }
}
