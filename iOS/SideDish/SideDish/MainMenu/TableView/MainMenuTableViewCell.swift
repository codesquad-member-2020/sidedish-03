//
//  MainMenuTableViewCell.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

final class MainMenuTableViewCell: UITableViewCell {
    
    // MARK: - IBOutlets
    @IBOutlet weak var foodImageView: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var priceView: PriceView!
    
    // MARK: - Properties
    static var identifier: String = "MainMenuTableViewCell"
    
    func updatePrice(normal normalPrice: String, sale salePrice: String) {
        priceView.updatePrice(normal: normalPrice, sale: salePrice)
    }
}
