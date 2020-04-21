//
//  EventBadgesCollectionViewCell.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

class EventBadgesCollectionViewCell: UICollectionViewCell {
    
    // MARK: - IBOutlets
    @IBOutlet weak var titleLabel: UILabel!
    
    // MARK: - Properties
    static var identifier: String = "EventBadgesCollectionViewCell"
    
    // MARK: - Lifecycles

    
    // MAKR: - Methods
    func apply(_ text: String) {
        titleLabel.text = text
    }
}
