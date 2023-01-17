using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    private float _speed = 3.5f;

    // Start is called before the first frame update
    void Start()
    {
        //set start position x=0, y=0, z=0
        transform.position = new Vector3(0, 0, 0);

    }

    // Update is called once per frame
    void Update()
    {
        PlayerMovement();

    }

    void PlayerMovement()
    {
        float horizontalIn = Input.GetAxis("Horizontal");
        float verticalIn = Input.GetAxis("Vertical");
        Vector3 moveDir = new Vector3(horizontalIn, verticalIn, 0);

        transform.Translate(moveDir * _speed * Time.deltaTime);

    //restricting player movement in the y plane between -3.9, 0
        transform.position = new Vector3(transform.position.x, Mathf.Clamp(transform.position.y, -3.9f, 0), 0);

        if (transform.position.x >= 9.5f)
        {
            transform.position = new Vector3(-9.5f, transform.position.y, 0);

        }
        else if (transform.position.x <= -9.5f)
        {
            transform.position = new Vector3(9.5f, transform.position.y, 0);

        }

    }
}
