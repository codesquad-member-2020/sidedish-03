//
//  StrikeThroughMaker.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

struct StrikeThroughMaker {
    // MARK: - Methods
    static func apply(_ input: String) -> NSMutableAttributedString {
        let attributedString: NSMutableAttributedString = NSMutableAttributedString(string: input)
        attributedString.addAttributes([NSAttributedString.Key.strikethroughStyle: NSUnderlineStyle.single.rawValue]
            , range: NSMakeRange(0, input.count))
        return attributedString
    }
}
