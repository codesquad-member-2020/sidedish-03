//
//  PriceView.swift
//  SideDish
//
//  Created by Cloud on 2020/04/23.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

@IBDesignable
class PriceView: UIStackView {
    
    // MARK: - IBOutlets
    private var normalPriceLabel: UILabel!
    private var salePriceLabel: UILabel!
    
    // MARK: - Lifecycles
    override init(frame: CGRect) {
        super.init(frame: frame)
        configure()
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
        configure()
    }
    
    override func prepareForInterfaceBuilder() {
        normalPriceLabel.attributedText = StrikeThroughMaker.apply("6,500")
        salePriceLabel.text = "5,400원"
    }
    
    // MARK: - Methods
    func updatePrice(normal normalPrice: String, sale salePrice: String ) {
        normalPriceLabel.attributedText = StrikeThroughMaker.apply(normalPrice)
        salePriceLabel.text = salePrice
    }
    
    private func configure() {
        applySetting()
        configureNormalPriceLabel()
        configureSalePriceLabel()
    }
    
    private func applySetting() {
        axis = .horizontal
        alignment = .center
        distribution = .fillProportionally
        spacing = 4
    }
    
    private func configureNormalPriceLabel() {
        normalPriceLabel = UILabel()
        addArrangedSubview(normalPriceLabel)
        configurePriceLabel(normalPriceLabel,
                            font: UIFont.systemFont(ofSize: 11),
                            alignment: .center,
                            color: .lightGray)
    }
    
    private func configureSalePriceLabel() {
        salePriceLabel = UILabel()
        addArrangedSubview(salePriceLabel)
        configurePriceLabel(salePriceLabel,
                            font: UIFont.boldSystemFont(ofSize: 13),
                            alignment: .center,
                            color: .systemTeal)
        
    }
    
    private func configurePriceLabel(_ label: UILabel, font: UIFont, alignment: NSTextAlignment, color: UIColor) {
        label.font = font
        label.textAlignment = alignment
        label.textColor = color
    }
}
