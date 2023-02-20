﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Laser : MonoBehaviour
{
    private float _speed = 8f;

    void Update()
    {
        transform.Translate(Vector3.up * _speed * Time.deltaTime);  

        if (transform.position.y > 7f)
        {
            if(transform.parent != null)
            {
                Destroy(transform.parent.gameObject);

            }

            Destroy(this.gameObject);

        }
    }
}
