//
//  PriceView.swift
//  SideDish
//
//  Created by Cloud on 2020/04/23.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit
import SnapKit

class PriceView: UIView {
    
    // MARK: - IBOutlets
    @IBOutlet weak var salePriceLabel: UILabel!
    @IBOutlet weak var normalPriceLabel: UILabel!
    
    // MARK: - Properties
    static var name: String = "PriceView"
    
    // MARK: - Lifecycles
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        configure()
    }
    
    func configure() {
        guard let priceView = Bundle.main
            .loadNibNamed(PriceView.name,
                          owner: self,
                          options: nil)?.first as? PriceView else { return }
        addSubview(priceView)
        priceView.snp.makeConstraints { make in
            make.edges.equalToSuperview()
        }
    }
}
