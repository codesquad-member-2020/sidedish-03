//
//  MainMenuTableViewCell.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

class MainMenuTableViewCell: UITableViewCell {
    
    // MARK: - IBOutlets
    @IBOutlet weak var foodImageView: UIImageView!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var normalPriceLabel: UILabel!
    @IBOutlet weak var sailPriceLabel: UILabel!
    @IBOutlet weak var badgesCollectionView: UICollectionView!
    
    // MARK: - Properties
    static var identifier: String = "MainMenuTableViewCell"
    
    func updateNormalPrice(_ text: String) {
        normalPriceLabel.attributedText = StrikeThroughMaker.apply(text)
    }
}
